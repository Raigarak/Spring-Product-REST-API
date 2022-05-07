# Spring Product REST API PostgreSQL

[Youtube Demo](https://www.youtube.com/watch?v=ulz_9niMiq8)

**API Endpoints**

`/api/v1/products` - return all products

`/api/v1/product/id/{id}` - searches the DB by id and returns the product details with id

`/api/v1/product/name/{name}` - searches the DB by name and returns the product details with name

`/api/v1/product/brand/{brand}` - searches the DB by name and returns the product details with brand

`/api/v1/addProduct` - takes JSON object and adds it to product table

`/api/v1/addProducts` - takes multiple JSON object and adds it to the product table

`/api/v1/update/{id}` - update product id with your JSON object body

`/api/v1/product/delete/{id}` - deletes the product with id

**Example Output for `/api/v1/products`**

```
{
    "name" : "K70 RGB PRO Mechanical Gaming Keyboard",
    "description" : "High end gaming keyboard",
    "brand" : "Corsair",
    "quantity" : 192,
    "price" : 169.99  
}
```
