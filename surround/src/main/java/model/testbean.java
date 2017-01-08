package model;

import java.sql.Blob;

public class testbean {
	private Blob member_photo;/*圖片*/

	public Blob getProduct_pic() {
		return member_photo;
	}

	public void setProduct_pic(Blob member_photo) {
		this.member_photo = member_photo;
	}
}
