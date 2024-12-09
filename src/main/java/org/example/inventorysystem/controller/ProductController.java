package org.example.inventorysystem.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.inventorysystem.model.Product;
import org.example.inventorysystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 모든 제품 조회 (Read All)
    @GetMapping
    public String listProducts(HttpSession session, Model model) {
        // 세션에서 사용자 정보 조회
        User user = (User) session.getAttribute("user");
        // 사용자 정보가 없으면 로그인 페이지로 리다이렉트
        if (user == null) {
            return "redirect:/login";
        }

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product-list"; // product-list.html
    }


    // 특정 제품 상세 조회 (Read One)
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-detail"; // product-detail.html
    }

    // 제품 추가 폼 (Create Form)
    @GetMapping("/create")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form"; // product-form.html
    }

    // 제품 추가 처리 (Create)
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, HttpSession session) {
        User user = (User) session.getAttribute("user"); // 세션에서 사용자 정보 가져오기
        product.setUser(user);
        productService.save(product);
        return "redirect:/products";
    }

    // 제품 수정 폼 (Update Form)
    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);

        model.addAttribute("product", product);
        return "product-form"; // product-form.html
    }

    // 제품 수정 처리 (Update)
    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    // 제품 삭제 처리 (Delete)
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
