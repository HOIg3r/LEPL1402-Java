import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

    public BiFunction<Boolean, Boolean, Boolean> xor_gate() {
        return (a,b) -> {
            if (a) {
                if(b){
                    return false;
                }
                return true;
            }
            return b;
        };
    }

    public BiFunction<Boolean, Boolean, Boolean> or_gate() {
        return (a,b) -> {
            if (a) {
                return true;
            }
            return b;
        };
    }

    public BiFunction<Boolean, Boolean, Boolean> and_gate() {
        return (a,b) -> {
            if (a) {
                return b;
            }
            return false;
        };
    }

    public Function<Boolean, Boolean> not_gate() {
        return (a) -> {
            if (a) {
                return false;
            }
            return true;
        };
    }

    // Should return a map containing the computation's results (use HashMap)
    // You're asked to store the results under the following keys: "SUM" & "carry_out"
    // TODO WARNING : ONLY USE the previously defined methods to compute the result
    // (INGInious will prevent you from cheating by directly invoking logical operators)
    public Map<String, Boolean> evaluate_circuit(Boolean a, Boolean b, Boolean carry_in) {
        Map<String,Boolean> map = new HashMap<>();
        map.put("SUM",xor_gate().apply(xor_gate().apply(a,b),carry_in));
        map.put("carry_out",or_gate().apply(and_gate().apply(carry_in,xor_gate().apply(a,b)), and_gate().apply(a,b)));
        return map;
    }

}