package calc.backend.interfaces;

import calc.backend.dto.CalcResponse;
import calc.backend.exceptions.InvalidOperationException;

public interface MathOperator {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
