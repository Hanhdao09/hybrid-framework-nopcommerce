package eclipseTips;

import org.openqa.selenium.WebDriver;

public class Topic_03_Getter_Setter {
	private WebDriver driver;
	private String carName;

	// generate constructor (constructor là hàm khởi tạo)
	public Topic_03_Getter_Setter(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// Generate hàm getter setter
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

}