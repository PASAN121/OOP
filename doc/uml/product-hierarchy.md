```mermaid
classDiagram
    class Product {
        <<abstract>>
        -id : Long
        -name : String
        -price : double
        +Product()
        +Product(id : Long, name : String, price : double)
        +getId() Long
        +getName() String
        +getPrice() double
        +getSummary()* String
    }

    class Discountable {
        <<interface>>
        +applyDiscount(rate : double) void
        +getDiscountedPrice() double
    }

    class DigitalProduct {
        -downloadUrl : String
        -fileSizeMb : double
        -discountedPrice : double
        +DigitalProduct()
        +DigitalProduct(id : Long, name : String, price : double, downloadUrl : String, fileSizeMb : double)
        +getDownloadUrl() String
        +getFileSizeMb() double
        +getSummary() String
        +applyDiscount(rate : double) void
        +getDiscountedPrice() double
    }

    class PhysicalProduct {
        -weightKg : double
        -dimension : String
        -discountedPrice : double
        +PhysicalProduct()
        +PhysicalProduct(id : Long, name : String, price : double, weightKg : double, dimension : String)
        +getWeightKg() double
        +getDimension() String
        +getSummary() String
        +applyDiscount(rate : double) void
        +getDiscountedPrice() double
    }

    Product <|-- DigitalProduct
    Product <|-- PhysicalProduct
    Discountable <|.. DigitalProduct
    Discountable <|.. PhysicalProduct
```
