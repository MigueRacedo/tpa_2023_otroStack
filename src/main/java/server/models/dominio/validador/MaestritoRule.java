package models.dominio.validador;

import org.passay.MatchBehavior;
import org.passay.PasswordData;
import org.passay.Rule;
import org.passay.RuleResult;

import java.util.LinkedHashMap;
import java.util.Map;
public class MaestritoRule implements Rule{

    @Override
    public RuleResult validate(PasswordData passwordData) {
        RuleResult result = new RuleResult();
        String user = passwordData.getUsername();
        if (user != null && !user.isEmpty()) {
            String contrasenia = passwordData.getPassword();

            contrasenia = contrasenia.toLowerCase();
            user = user.toLowerCase();

            if (contrasenia.contains("maestrito")) {
                result.addError("CONTAINS_MAESTRITO", this.createRuleResultDetailParameters(contrasenia));
                //throw new RuntimeException("La contrasenia no debe contener la palabra maestrito");
            }
        }
        return result;
    }
    protected Map<String, Object> createRuleResultDetailParameters(String contrasenia) {
        Map<String, Object> m = new LinkedHashMap();
        m.put("contrasenia", contrasenia);
        m.put("matchBehavior", MatchBehavior.Contains);
        return m;
    }
}