package com.elira.pos.controller;

import com.elira.pos.exceptions.UserException;
import com.elira.pos.modal.User;
import com.elira.pos.payload.dto.ProductDTO;
import com.elira.pos.payload.response.ApiResponse;
import com.elira.pos.service.ProductService;
import com.elira.pos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO,
                                             @RequestHeader("Authorization") String jwt) throws UserException {

        User user = userService.getUserFromToken(jwt);
        return ResponseEntity.ok(
                productService.createProduct(
                        productDTO,
                        user
                )
        );
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<ProductDTO>> getByStoreId(
            @PathVariable Long storeId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(
                productService.getProductsByStoreId(
                    storeId
                )
        );

    }

    @PatchMapping("{id}")
    public ResponseEntity<ProductDTO> update(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.getUserFromToken(jwt);
        return ResponseEntity.ok(
                productService.updateProduct(
                        id,
                        productDTO,
                        user
                )
        );
    }

    @GetMapping("/store/{storeId}/search")
    public ResponseEntity<List<ProductDTO>> searchByKeyword(
            @PathVariable Long storeId,
            @RequestParam String keyword,
            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(
                productService.searchByKeyword(
                        storeId,
                        keyword
                )
        );

    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.getUserFromToken(jwt);

        productService.deleteProduct(
                id,
                user
        );
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Product deleted successfully");
        return ResponseEntity.ok(
                apiResponse
        );
    }


}
