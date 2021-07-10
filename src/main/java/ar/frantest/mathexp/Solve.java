package ar.frantest.mathexp;

import com.github.ayaanqui.expressionresolver.Resolver;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solve {
    private String expression;
    private int presicion;

    public Solve(String expression, int presicion) {
        this.expression = expression;
        this.presicion = presicion;
    }

    public String getExpression() {
        return expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getPresicion() {
        return presicion;
    }
    public void setPresicion(int presicion) {
        this.presicion = presicion;
    }

    public double solveExpression(String expression, int precision){
        Resolver solver = new Resolver();

        //solver.setExpression("20+2-12+(10*7)*sqrt(25)+1234.56789"); //test
        /*Log*/ System.out.println("("+Solve.class.getName()+ ") Expression: " + expression);
        solver.setExpression(expression);

        double result = 0;
        if (solver.solveExpression().success) { //ok
            result = solver.getLastResult();
            if (precision != 0) {
                result = BigDecimal.valueOf(result).setScale(precision, RoundingMode.HALF_UP).doubleValue();
            }
            /*Log*/ System.out.println("("+Solve.class.getName()+ ") Result: " + result);
        } else { //error
            String msg = "Wrong expression dude, please try again!";
            /*Log*/ System.out.println("("+Solve.class.getName()+ ") Error: " + msg);
        }

        return result;
    } //end method solveExpression
}
