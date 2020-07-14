
public class ChartTickTest {
	public static void main(String[] args) {
		int maxValue = 140;
		double axesMaxValue = 0.0;
		
		double stepSize = getTicksStepSize(maxValue);
		int iStepSize = (int) stepSize;
		System.out.println("iStepSize=" + iStepSize);
		
		if (maxValue % iStepSize > iStepSize / 2) {
			axesMaxValue = ((maxValue / iStepSize) + 2) * iStepSize * 1.0;
		} else { //if (maxValue % iStepSize == 0){
			axesMaxValue = ((maxValue / iStepSize) + 1) * iStepSize * 1.0;
		}
		
		System.out.println("axesMaxValue=" + axesMaxValue);
	}

	private static double getTicksStepSize(int i) {
		double stepSize = 0.0;
		if (i <= 5) {
			stepSize = 0.5;
		} else if (i <= 10) {
			stepSize = 1.0;
		} else if (i <= 20) {
			stepSize = 2.0;
		} else {
			int quotient = i / 10;
			int remainder = i % 10;
			if (remainder > 0) {
				quotient++;
			}
			stepSize = 10 * getTicksStepSize(quotient);
		}
		return stepSize;
	}
}
