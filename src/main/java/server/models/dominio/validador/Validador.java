package server.models.dominio.validador;

import server.models.dominio.excepciones.ContraseniaDebilException;
import server.models.dominio.usuario.Usuario;
import org.passay.*;
import org.passay.dictionary.Dictionary;
import org.passay.dictionary.DictionaryBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validador {
    private static Validador instancia = null;
    List<Rule> reglas = new ArrayList<>();
    public Validador(){
        aniadirRegla(reglaConClavesBaneadas());
        aniadirRegla(new LengthRule(8, 64));
        aniadirRegla(new UsernameRule());
        aniadirRegla(new MaestritoRule());
    }
    public static Validador getInstance(){
        if(instancia == null){
            instancia = new Validador();
        }
        return instancia;
    }

    public void aniadirRegla(Rule regla){
        reglas.add(regla);
    }
    public void validarUsuarioContrasenia(String usuario, String contrasenia){
        if (usuario == null) {
            throw new RuntimeException("Debe ingresar un usuario.");
        }
        validarContrasenia(usuario, contrasenia);
    }
    public void validarContrasenia(String usuario, String contrasenia) {

        if (contrasenia == null) {
            throw new RuntimeException("Debe ingresar una contraseña.");
        }

        PasswordData passwordData = new PasswordData();
        passwordData.setUsername(usuario);
        passwordData.setPassword(contrasenia);

        PasswordValidator validator = getValidador();

        RuleResult validate = validator.validate(passwordData);
        if (!validate.isValid()) {
            throw new ContraseniaDebilException(getMensajeDeError(validate));
        }
    }

    public PasswordValidator getValidador() {
        return new PasswordValidator(reglas);
    }
    public String getMensajeDeError(RuleResult validate) {
        RuleResultDetail ruleResultDetail = validate.getDetails().get(0);
        return String.valueOf(getDiccionarioDeErrores().get(ruleResultDetail.getErrorCode()));
    }

    public Map<String, String> getDiccionarioDeErrores() {
        Map<String, String> diccionarioDeErrores = new HashMap<>();
        diccionarioDeErrores.put("ILLEGAL_WORD", "La contraseña ingresada es muy fácil.");
        diccionarioDeErrores.put("TOO_SHORT", "La contraseña debe tener al menos 8 caracteres.");
        diccionarioDeErrores.put("TOO_LONG", "La contraseña puede tener 64 caracteres como máximo.");
        diccionarioDeErrores.put("CONTAINS_MAESTRITO", "La contrasenia no debe contener la palabra maestrito");
        return diccionarioDeErrores;
    }

    public DictionaryRule reglaConClavesBaneadas() {
        ClassLoader classLoader = Usuario.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("Documentación/10-million-password-list-top-10000.txt");
        DictionaryBuilder dictionaryBuilder = new DictionaryBuilder();
        assert inputStream != null;
        Dictionary diccionarioContraseniasFaciles = dictionaryBuilder.addReader(new InputStreamReader(inputStream)).build();
        return new DictionaryRule(diccionarioContraseniasFaciles);
    }
}
