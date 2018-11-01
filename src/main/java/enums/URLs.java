package enums;

public enum URLs {
        HOME_PAGE_URL("https://epam.github.io/JDI/");

        private String url;

        URLs(String url) {
            this.url = url;
        }

        public String getUrl() {
            return this.url;
        }



}
