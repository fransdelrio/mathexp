package ar.frantest.mathexp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "solve")
public class SolveRest {

    @GetMapping
    public double solve(@RequestParam(value = "expression", defaultValue = "") String expression, @RequestParam(value = "precision", defaultValue = "2") int precision){
        System.out.println("> Expresion: " + expression +". Presicion: " + precision);
        return Solve.solveExpression(expression, precision);
    }
}

