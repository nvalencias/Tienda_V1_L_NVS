package com.tienda.service;

import org.springframework.web.multipart.MultipartFile;
public interface FirebaseStorageService {
    //esta clase es para subir las imagenes al firebase, con un metodo
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-72a82.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-72a82-firebase-adminsdk-w3nyj-5d2860cbd4.json";
}
