package com.product.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.product.constant.Constant;
import com.product.model.Product;

public class ReadFiles {
	public static List<Product> read() throws IOException {

		Path path = Paths.get(Constant.FILES_PATH);
		Stream<Path> filesPath = Files.walk(path, 1).skip(1);
		List<Product> filesData = new ArrayList<>();
		filesPath.forEach(filePath -> {
			try {
				CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath.toString())).withSkipLines(1)
						.build();
				String[] datas;// change
				try {
					while ((datas = csvReader.readNext()) != null) { // return string array
						Product product = new Product();
						for (String dataRow : datas) { // change
							String[] data = dataRow.split("\\|");// read
							product.setId(data[0]);
							product.setName(data[1]);
							product.setColour(data[2]);
							product.setGender(data[3]);
							product.setSize(data[4]);
							product.setPrice(Double.parseDouble(data[5]));
							product.setRating(Double.parseDouble(data[6]));
							product.setAvailability(data[7].charAt(0));
						}
						filesData.add(product);
					}
				} catch (CsvValidationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return filesData;
	}
}
