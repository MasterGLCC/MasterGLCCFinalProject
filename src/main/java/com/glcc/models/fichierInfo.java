package com.glcc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class fichierInfo {
	  private String filename;
	    private String url;
		public fichierInfo(String filename, String url) {
			super();
			this.filename = filename;
			this.url = url;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	
}
