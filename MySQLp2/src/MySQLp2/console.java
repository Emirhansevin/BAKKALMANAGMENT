package MySQLp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class console {
	static int adetGetir() {
		int adet;
		System.out.println("Kaç adet almak istersiniz?");
		var adetScan=new Scanner(System.in);
		adet=adetScan.nextInt();
		return adet;
	}
	
	static void stokAzaltma(int adet,int barkod) {
		int stok2=0;
		String urunIsmi="";
		String updateQuery= "UPDATE urun SET stok=stok-?  WHERE barkod=?";
		
		try {
			Connection myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","12345");
			Statement myStat= myconn.createStatement();
			ResultSet rs= myStat.executeQuery("select * from urun");
			PreparedStatement ps = myconn.prepareStatement(updateQuery);
			while(rs.next()) {
				if(barkod==rs.getInt("barkod")) {
					stok2=rs.getInt("stok");
					urunIsmi=rs.getString("urunad");
					}
			}
			if (adet > stok2) {
				System.out.println("Stokta o kadar ürünümüz yoktur."
						+ "Stoktaki " + urunIsmi + " adedimiz: " + stok2);
			}
			else if (adet<0) {
				System.out.println("hatalı işlem yaptınız!!");
				
			}
			else {
				ps.setInt(1, adet);
				ps.setInt(2, barkod);
				ps.executeUpdate();
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int fiyatGetir(int adet,int barkod2) {
		int fiyat=0;
		int stok2=0;
		try {
			Connection myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","12345");
			Statement myStat= myconn.createStatement();
			ResultSet rs= myStat.executeQuery("select * from urun");

			
			while(rs.next()) {
				if(barkod2==rs.getInt("barkod")) {
					fiyat=rs.getInt("urunfiyat");
					stok2=rs.getInt("stok");
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			if (adet > stok2) {
				return 0;
			}
			else if (adet<0) {
				return 0;
			}
			else {
				return fiyat*adet;
			}
	}
	static String adGetir(int adet,int barkod) {
		String ad= "";
		int stok2=0;
		try {
			Connection myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","12345");
			Statement myStat= myconn.createStatement();
			ResultSet rs= myStat.executeQuery("select * from urun");

			
			while(rs.next()) {
				if(barkod==rs.getInt("barkod")) {
					ad=rs.getString("urunad");
					stok2=rs.getInt("stok");
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			if (adet > stok2) {
				return "";
			}
			else if (adet<0) {
				return "";
				
			}
			else {
				return adet+" adet "+ad+"\n";
			}
	}
	
	public static void main(String[] args) {
		int secim;
		int adet;
		int barkod;
		boolean kontrol=true;
		int sepetUcret=0;
		String sepet="";
		
		while(kontrol) {
			System.out.println("1-sepetine ürün ekle");
			System.out.println("2-alişverişten ayrıl");
			Scanner scan = new Scanner(System.in);
			secim=scan.nextInt();
			
				
					
		switch (secim) {
		case 1:
			boolean kontrol1=true;
			int secim1;
			while(kontrol1) {
				System.out.println("Hangi reyona gitmek istersiniz?\n"
						+ "1.Bakliyat Reyonu\t"
						+ "2.İçecek Reyonu\n"
						+ "3.Unlu Mamüller Reyonu \t"
						+ "4.Süt Ürünleri Reyonu\t"
						+ "5.Çıkış");
				
				var scan1 = new Scanner(System.in);
					secim1=scan1.nextInt();
				 	
			switch (secim1) {
			case 1:
				boolean kontrol2=true;
				int secim2;
				while(kontrol2) {
					
					
					System.out.println("Ne almak istersiniz?\n"
							+ "1.Makarna\n"
							+ "2.Pirinç\n"
							+ "3.Bulgur\n"
							+ "4.Reyona geri dön!");
					var scan2=new Scanner(System.in);
					secim2=scan2.nextInt();
					switch (secim2) {
					case 1: 
						barkod=1;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 2:
						barkod=2;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 3:
						barkod=3;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 4:
						System.out.println("Reyona geri dönüyorsunuz...\n");
						kontrol2=false;
						break;
					default:
						System.out.println("Hatali Giriş Yaptınız!\n");
						break;
					}
				}
				
				break;
			case 2:
				boolean kontrol3=true;
				int secim3;
				while(kontrol3) {
					System.out.println("Ne almak istersiniz?\n"
				
						+ "1.su \n"
						+ "2.kola\n"
						+ "3.ayran\n"
						+ "4.Reyona geri dön!");
					var scan3= new Scanner(System.in);
					secim3=scan3.nextInt();
					switch (secim3) {
					case 1: 
						barkod=4;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 2:
						barkod=5;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 3:
						barkod=6;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 4:
						System.out.println("Reyona geri dönüyorsunuz...\n");
						kontrol3=false;
						break;
					default:
						System.out.println("Hatali Giriş Yaptınız!\n");
						break;
					}
					
				}
				break;
			case 3:
				boolean kontrol4=true;
				int secim4;
				while(kontrol4) {
					System.out.println("Ne almak istersiniz?\n"
							
						+ "1.ekmek \n"
						+ "2.yufka\n"
						+ "3.bazlama\n"
						+ "4.Reyona geri dön!");
					var scan4= new Scanner(System.in);
					secim4=scan4.nextInt();
					switch (secim4) {
					case 1: 
						barkod=7;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 2:
						barkod=8;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 3:
						barkod=9;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 4:
						System.out.println("Reyona geri dönüyorsunuz...\n");
						kontrol4=false;
						break;
					default:
						System.out.println("Hatali Giriş Yaptınız!\n");
						break;
					}
					
				}
				break;
			case 4:
				boolean kontrol5 = true;
				int secim5;
				while(kontrol5) {
					System.out.println("Ne almak istersiniz?\n"
							
						+ "1.peynir \n"
						+ "2.süt \n"
						+ "3.yoğurt\n"
						+ "4.Reyona geri dön!");
					var scan5= new Scanner(System.in);
					secim5=scan5.nextInt();
					switch (secim5) {
					case 1: 
						barkod=10;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 2:
						barkod=11;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 3:
						barkod=12;
						adet=adetGetir();
						stokAzaltma(adet, barkod);
						sepetUcret+=fiyatGetir(adet, barkod);
						sepet =sepet+adGetir(adet, barkod);
						break;
					case 4:
						System.out.println("Reyona geri dönüyorsunuz...\n");
						kontrol5=false;
						break;
					default:
						System.out.println("Hatali Giriş Yaptınız!\n");
						break;
					}
					
				}
				break;
			case 5:
				System.out.println("Kasaya Yönlendiriliyorsunuz.");
				kontrol1=false;
				break;
			
			default:
				System.out.println("Hatali Giriş Yaptınız!\n");
				break;
			}}
		

			break;
		case 2:
			if (sepetUcret>0) {
				System.out.printf("Sepet Bilginiz:\n"
						+ sepet+"\n");
				System.out.println("Ücretiniz " + sepetUcret + " TL'dir.Lütfen Ödeyiniz!");
			}
			else {
				System.out.println("Bir mahalle bakkalı olarak alışveriş yapmamanıza çok üzüldük yine de \n");
			}
			System.out.println("İyi Künler!!!");
			kontrol=false;
			break;
		default:
			System.out.println("Hatali Giriş Yaptınız!\n");
			break;
		}
		
		}
		
	}
}
