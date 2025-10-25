import { Badge } from '@/components/ui/badge'
import { Card, CardContent } from '@/components/ui/card'

import React from 'react'

const ProductCard = ({product}) => {
  return (
    <Card key={Math.random()} className="py-4">

      <CardContent className={""}>
        <div className="aspect-square bg-muted rounded-md mb-2 flex
        items-center justify-center">

          
            <img className='h-30 w-30 object-cover'
              src={product.image}
              alt="" />
        </div>

        <div className="">
          <h3 className='font-medium text-sm  truncate'>{product.name}</h3>
          <p className='text-xs text-muted-foreground' >{product.sku}</p>

          <div className='flex items-center justify-between' >
            <p className='font-semibold text-yellow-700' >
              ${product.sellingPrice}
            </p>
            <Badge variant="secondary" className='text-xs'>{product.category}</Badge>
          </div>
        </div>
      </CardContent>
    </Card>
  )
}

export default ProductCard