package paket;

import java.io.Serializable;

public class Hasta implements Serializable {
	private String adsoyad;
	private String cinsiyet;
	private int yas;
	private double kilo;
	private double boy;
	
	public Hasta(String adsoyad, String cinsiyet, int yas, double kilo, double boy) {
		super();
		this.adsoyad = adsoyad;
		this.cinsiyet = cinsiyet;
		this.yas = yas;
		this.kilo = kilo;
		this.boy = boy;
	}

	public String getAdsoyad() {
		return adsoyad;
	}

	public void setAdsoyad(String adsoyad) {
		this.adsoyad = adsoyad;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public double getKilo() {
		return kilo;
	}

	public void setKilo(double kilo) {
		this.kilo = kilo;
	}

	public double getBoy() {
		return boy;
	}

	public void setBoy(double boy) {
		this.boy = boy;
	}
	
	
	
}
