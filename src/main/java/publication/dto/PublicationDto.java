package publication.dto;


public class PublicationDto {

        private Long id;
        private String titre;

        private String resume;

        private String article;
        private String code;
        private String Certificat;

        public PublicationDto() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public PublicationDto(Long id, String titre, String resume, String article, String code, String certificat) {
                this.id = id;
                this.titre = titre;
                this.resume = resume;
                this.article = article;
                this.code = code;
                Certificat = certificat;
        }

        public PublicationDto(String titre, String resume, String articlePDF, String codeSourceZIP, String certificatePDF) {
                this.titre = titre;
                this.resume = resume;
                this.article = articlePDF;
                this.code= codeSourceZIP;
                Certificat= certificatePDF;

        }

        public String getTitre() {
                return titre;
        }

        public void setTitre(String titre) {
                this.titre = titre;
        }

        public String getResume() {
                return resume;
        }

        public void setResume(String resume) {
                this.resume = resume;
        }

        public String getArticle() {
                return article;
        }

        public void setArticle(String articlePDF) {
                this.article = articlePDF;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String codeSourceZIP) {
                this.code = codeSourceZIP;
        }

        public String getCertificat() {
                return Certificat;
        }

        public void setCertificat(String certificatePDF) {
                Certificat = certificatePDF;
        }
}

