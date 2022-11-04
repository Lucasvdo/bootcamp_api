package br.com.bootcamp.controller;

import br.com.bootcamp.domain.dto.ProductDto;
import br.com.bootcamp.domain.response.UpdateProductDtoResponse;
import br.com.bootcamp.entity.Product;
import br.com.bootcamp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     ResponseEntity<ProductDto> registerProduct(
            @RequestHeader(value = "productName",required = true) String productName,
            @RequestHeader(value = "productValue",required = true) BigDecimal productValue)
    {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(productName);
        productDto.setProductValue(productValue);
        productService.insertNewProduct(productDto);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
    }

    @RequestMapping(value= "/updateProduct", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UpdateProductDtoResponse> changeProduct(@RequestBody ProductDto productDto)
    {
        UpdateProductDtoResponse response = productService.updateProduct(productDto);
        return new ResponseEntity<UpdateProductDtoResponse>(response, HttpStatus.OK);
    }

    @RequestMapping(value= "/removeProduct/{idProduct}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDto> removeProduct(@PathVariable(value = "idProduct",required = true) Long idProduct){
        productService.deleteProductDto(idProduct);
        return new ResponseEntity<ProductDto>(new ProductDto(), HttpStatus.OK);
    }

    @RequestMapping(value= "/findProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDto>findProductById(@RequestParam(value = "productId") Long productId)
    {
        ProductDto response = productService.findProductById(productId);
        return new ResponseEntity<ProductDto>(response,HttpStatus.OK);
    }

    @RequestMapping(value= "/findProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDto>>findAllProducts()
    {
        List<ProductDto> response = productService.findAllProducts();
        return new ResponseEntity<List<ProductDto>>(response,HttpStatus.OK);
    }

}
