package ar.frantest.mathexp;

import com.github.ayaanqui.expressionresolver.Resolver;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solve {
    private String expression;
    private double presicion;

    public Solve(String expression, double presicion) {
        this.expression = expression;
        this.presicion = presicion;
    }

    public static double solveExpression(String expression, int precision){
        Resolver solver = new Resolver();

        //solver.setExpression("20+2-12+(10*7)*sqrt(25)+1234.56789");
        System.out.println(expression);
        solver.setExpression(expression);

        double result = 0;
        String msg="";
        if (solver.solveExpression().success) { //ok
            result = solver.getLastResult();
            if (precision == 0) {
                System.out.println(result);
            } else {
                result = BigDecimal.valueOf(result).setScale(precision, RoundingMode.HALF_UP).doubleValue();
                System.out.println(result);
            }
        } else { //error
            msg = "Wrong expression dude, please try again!";
            System.out.println(msg);
        }

        return result;
    } //end method solveExpression
}
