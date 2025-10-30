import { Card, CardContent } from '@/components/ui/card'
import React from 'react'

const shiftData = {
  topSellingItems: [
    
    {
      id: 1,
      name: "Men Geometric Print Polo Shirt",
      sellingPrice: 305,
      quantity: 5
    },
    {
      id: 2,
      name: "Women Geometric Print Polo Shirt",
      sellingPrice: 485,
      quantity: 9
    },
  ]
}

const TopSellingItems = () => {
  return (
    <Card>
      <CardContent>
        <h2 className="text-xl font-semibold mb-4">
          Top Selling Items
        </h2>

        <div className="space-y-3">
          {
            shiftData.topSellingItems.map((product, index) =>
            <div key={product.id} className="flex items-center">

              <div className="w-6 h-6 rounded-full bg-primary/10 flex
               items-center justify-center mr-3 font-medium text-sm">
                {index + 1}
              </div>

              <div className="flex-1">
                <div className="flex justify-between">
                  <span className="">{product.name}</span>
                  <span className="">${product.sellingPrice}</span>
                </div>

                <div className="flex justify-between text-sm text-muted-foreground">
                  <span className=""> {product.quantity} unit sold</span>
                </div>
              </div>
            </div>)
          }
        </div>
      </CardContent>
    </Card> 
  )
}

export default TopSellingItems