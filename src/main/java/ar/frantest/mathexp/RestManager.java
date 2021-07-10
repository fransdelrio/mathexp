package ar.frantest.mathexp;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
@RequestMapping("/api")
public class RestManager {

    @GetMapping("/getSolve")
    public double getSolve(@RequestParam(value = "expression", defaultValue = "") String expression, @RequestParam(value = "precision", defaultValue = "0") int precision){
    /*Log*/ System.out.println("("+RestManager.class.getName()+ ".getSolve) Expresion: " + expression +". Presicion: " + precision);
        Solve s = new Solve(expression, precision);
        return s.solveExpression(expression, precision);
    }

    @PostMapping("/postSolve")
    public double postSolve(@RequestBody Solve s) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(s);
    /*Log*/ System.out.println("("+RestManager.class.getName()+ ".postSolve) JSON: " + json);
        return s.solveExpression(s.getExpression(), s.getPresicion());
    }

} //end class RestManager
