package calc.backend.controller;

import calc.backend.utils.CalcResponse;
import calc.backend.dto.DoMathRequest;
import calc.backend.exceptions.InvalidOperationException;
import calc.backend.impl.MathOperatorImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/")
public class MathController {
    MathOperatorImpl mathOperatorImpl = new MathOperatorImpl();

    @RequestMapping(value="/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
    @ResponseBody
    public CalcResponse doMath(@RequestBody DoMathRequest doMathRequest) throws InvalidOperationException {
        double result = mathOperatorImpl.doMath(doMathRequest.getOperand1(), doMathRequest.getOperand2(), doMathRequest.getOperation());
        CalcResponse response = new CalcResponse(result);
        return response;
    }
}
