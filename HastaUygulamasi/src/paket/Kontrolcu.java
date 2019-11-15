package paket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Kontrolcu implements Initializable {

    @FXML
    private TextField txtAdSoyad;

    @FXML
    private RadioButton rdbErkek;

    @FXML
    private RadioButton rdbKadin;

    @FXML
    private Spinner<Integer> spnYas;

    @FXML
    private Spinner<Double> spnKilo;

    @FXML
    private Spinner<Double> spnBoy;

    @FXML
    private ComboBox<String> cmbHasta;

    @FXML
    private TextField txtCinsiyet;

    @FXML
    private TextField txtYas;

    @FXML
    private TextField txtKilo;

    @FXML
    private TextField txtBoy;

    private ArrayList<Hasta> hastalar = new ArrayList<Hasta>();
    public void bilgiGoster() {
    	int index = cmbHasta.getSelectionModel().getSelectedIndex();
    	Hasta hasta = hastalar.get(index);
    	txtCinsiyet.setText(hasta.getCinsiyet());
    	txtBoy.setText(hasta.getBoy() + " metre");
    	txtKilo.setText(hasta.getKilo() + " kilogram");
    	txtYas.setText(hasta.getYas() + "");
    }
    
    public void kayitEt() {
    	String adsoyad = txtAdSoyad.getText();
    	String cinsiyet;
    	if (rdbErkek.isSelected()) {
			cinsiyet = "Erkek";
		} else {
			cinsiyet = "Kadýn";
		}
    	int yas = spnYas.getValue();
    	double kilo = spnKilo.getValue();
    	double boy = spnBoy.getValue();
    	Hasta hasta = new Hasta(adsoyad, cinsiyet, yas, kilo, boy);
    	hastalar.add(hasta);
    	isimler.add(adsoyad);
    	//For File Write
    	//Dosyaya yazmak için
    	try {
    		FileOutputStream fos = new FileOutputStream("hastalar.dat");
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
    		oos.writeObject(hastalar);
    		oos.close();
    	} catch (Exception e) {
    		System.out.println("Dosyaya yazma hatasý..");
    	}
    
    }
    
    private ObservableList<String> isimler = FXCollections.observableArrayList();
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup grup = new ToggleGroup();
		rdbErkek.setToggleGroup(grup);
		rdbKadin.setToggleGroup(grup);
		
		//Arg0 = Min Value Arg1 = Max Value Arg2 = Default Value Arg3 = Increment
		spnYas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 120, 35, 1));
		spnBoy.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.4, 2.30, 1.6, 0.1));
		spnKilo.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(2, 320, 70, 0.1));
		cmbHasta.setItems(isimler);
		//For File Reading
		//Dosya okumak için
		try {
			FileInputStream fis = new FileInputStream("hastalar.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			hastalar = (ArrayList<Hasta>) ois.readObject();
			for (int i = 0; i < hastalar.size(); i++) {
				isimler.add(hastalar.get(i).getAdsoyad());
			}
		} catch (Exception e) {
			System.out.println("Dosya okuma hatasý...");
		}
		
	}

    
    
    
}
