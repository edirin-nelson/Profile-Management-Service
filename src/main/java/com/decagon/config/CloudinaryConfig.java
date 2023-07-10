package com.decagon.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.cloud_name}")
    private String CLOUD_NAME;

    @Value("${cloudinary.api_key}")
    private String CLOUD_KEY;

    @Value("${cloudinary.api_secret}")
    private String CLOUD_SECRET;

    public String imageLink(MultipartFile file,String id){

        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", CLOUD_KEY);
        config.put("api_secret", CLOUD_SECRET);
        Cloudinary cloudinary = new Cloudinary(config);

        try {
            cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", "image_id"+id));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        String url = cloudinary.url().transformation(new Transformation().width(200).height(250).crop("fill")).generate("image_id"+id);
        System.out.println(url);
        return url;
    }
}
