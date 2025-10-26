import { Separator } from '@/components/ui/separator'
import React from 'react'

const CartSummary = () => {
  return (
    <div className='border-t bg-muted p-4'>
      <div className="space-y-2 text-sm">
        <div className="flex justify-between">
          <span>Subtotal</span>
          <span>$60.00</span>
        </div>
        <div className="flex justify-between">
          <span>Tax (10%)</span>
          <span>$6.00</span>
        </div>
        <Separator />
        <div className="flex justify-between">
          <span>Total</span>
          <span>$66.00</span>
        </div>
      </div>
      
    </div>
  )
}

export default CartSummary