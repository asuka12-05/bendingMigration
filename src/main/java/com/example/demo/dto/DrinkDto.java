package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ドリンクDTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrinkDto {
	
	/** ID */
	private int id;
	/** ドリンクの名前 */
	private String name;
	/** 価格(円) */
	private int price;
	/** 在庫(本数) */
	private int inventory;
	/** ドリンクの温度状態 */
	private DrinkTemperature temperature;
	/** ドリンクの画像 */
	private String imageFile;
	
	/**
	 * 画像の取得
	 * @return	ファイル名
	 */
	public String getImagePath() {
	    if (imageFile != null && !imageFile.isEmpty()) {
	        return imageFile;
	    }
	    return id + ".png";
	}

}
