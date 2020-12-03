package jianzhi;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class SolutionSize {
    private BigDecimal height;
    private BigDecimal topLength;
    private BigDecimal buttonLength;

    private BigDecimal k;

    private BigDecimal b;

    private LinkedList<Integer> list;

    public List<Integer> solutionCutSize(BigDecimal height, BigDecimal topLength,BigDecimal  buttonLength){
        list=new LinkedList<>();
        BigDecimal area=topLength.add(buttonLength).multiply(height);
        BigDecimal average = area.divide(BigDecimal.valueOf(44), 6);
        BigDecimal testTriangleHeight = buttonLength.divide(topLength).multiply(height);
        k= calK(topLength,buttonLength);
        return list;
    }

    private BigDecimal calK(BigDecimal topLength, BigDecimal buttonLength) {

        return null;
    }
}
