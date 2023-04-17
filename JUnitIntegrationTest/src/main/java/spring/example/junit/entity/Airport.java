package spring.example.junit.entity;


public class Airport {
	    public int id;
	    public String iata;
	    public String icao;
	    public String name;
	    public String location;
	    public String street_number;
	    public String street;
	    public String city;
	    public String county;
	    public String state;
	    public String country_iso;
	    public String country;
	    public Airport() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Airport(int id, String iata, String icao, String name, String location, String street_number,
				String street, String city, String county, String state, String country_iso, String country,
				String postal_code, String phone, double latitude, double longitude, int uct, String website) {
			super();
			this.id = id;
			this.iata = iata;
			this.icao = icao;
			this.name = name;
			this.location = location;
			this.street_number = street_number;
			this.street = street;
			this.city = city;
			this.county = county;
			this.state = state;
			this.country_iso = country_iso;
			this.country = country;
			this.postal_code = postal_code;
			this.phone = phone;
			this.latitude = latitude;
			this.longitude = longitude;
			this.uct = uct;
			this.website = website;
		}
		@Override
		public String toString() {
			return "Airport [id=" + id + ", iata=" + iata + ", icao=" + icao + ", name=" + name + ", location="
					+ location + ", street_number=" + street_number + ", street=" + street + ", city=" + city
					+ ", county=" + county + ", state=" + state + ", country_iso=" + country_iso + ", country="
					+ country + ", postal_code=" + postal_code + ", phone=" + phone + ", latitude=" + latitude
					+ ", longitude=" + longitude + ", uct=" + uct + ", website=" + website + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIata() {
			return iata;
		}
		public void setIata(String iata) {
			this.iata = iata;
		}
		public String getIcao() {
			return icao;
		}
		public void setIcao(String icao) {
			this.icao = icao;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getStreet_number() {
			return street_number;
		}
		public void setStreet_number(String street_number) {
			this.street_number = street_number;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCounty() {
			return county;
		}
		public void setCounty(String county) {
			this.county = county;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry_iso() {
			return country_iso;
		}
		public void setCountry_iso(String country_iso) {
			this.country_iso = country_iso;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getPostal_code() {
			return postal_code;
		}
		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public int getUct() {
			return uct;
		}
		public void setUct(int uct) {
			this.uct = uct;
		}
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}
		public String postal_code;
	    public String phone;
	    public double latitude;
	    public double longitude;
	    public int uct;
	    public String website;
	}



