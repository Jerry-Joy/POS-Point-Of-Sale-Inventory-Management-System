import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import { Barcode } from 'lucide-react'
import React from 'react'
import ProductCard from './ProductCard'

const products = [{
  id: 1,
  image:"https://images.pexels.com/photos/33340052/pexels-photo-33340052.jpeg",
  name: "Product Name",
  sku: "SKU12345",
  sellingPrice: "899",
  category: "men-shirt"
},
{
  id: 1,
  image:"https://images.pexels.com/photos/33340052/pexels-photo-33340052.jpeg",
  name: "Product Name",
  sku: "SKU12345",
  sellingPrice: "899",
  category: "men-shirt"
},
{
  id: 1,
  image:"https://images.pexels.com/photos/33340052/pexels-photo-33340052.jpeg",
  name: "Product Name",
  sku: "SKU12345",
  sellingPrice: "899",
  category: "men-shirt"
},
]

const ProductSection = () => {

  const [searchTerm, setSearchTerm] = React.useState("")

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value)
  }
  return (
    <div className='w-2/5 flex flex-col bg-card border-r'>
      <div className='p-4 border-b bg-muted'>
        
        <div>
          <Input className={"py-5"} placeholder="Search products..." value={searchTerm} type={"text"} onChange={handleSearchChange} />
        </div>

        <div className='flex items-center justify-between pt-2' >
        <span>{2} products found</span>
        <Button variant="outline" size="sm" className="text-xs" ><Barcode/> scan</Button>
      </div>
      </div>

      <div className="grid lg:grid-cols-3 md:grid-cols-2 sm:grid-cols-1 gap-3 p-5 ">
        {products.map((product, index) => (
          <ProductCard product={product} key={index} />
        ))}
      </div>

      
    </div>
  )
}

export default ProductSection