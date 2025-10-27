
import { Button } from '@/components/ui/button'
import { CreditCard, Pause } from 'lucide-react'
import React from 'react'

const PaymentSection = () => {
  const cartItems = [
    { id: 1, name: "Item 1", price: 299 },
    { id: 2, name: "Item 2", price: 600 },
  ];
  return (
    <div className='flex flex-1 flex-col p-4 justify-end'>
      <div className="space-y-4">
        <div className="text-center">
          <h1 className="text-3xl font-bold text-yellow-600 dark:text-yellow-200">
            {899}$
          </h1>
          <p className="text-sm text-muted-foreground">
            Total Amount
          </p>
        </div>

        <div className="space-y-3">
          <Button disabled={cartItems.length === 0} className={"w-full py-3 text-lg font-semibold"}>
            <CreditCard className='w-5 h-5 mr-2' />
            Proccess Payment
          </Button>

          <Button variant={"outline"} disabled={cartItems.length === 0} className={"w-full py-3 text-lg font-semibold"}>
            <Pause className='w-5 h-5 mr-2' />
            Proccess Payment
          </Button>
        </div>
      </div>
      
    </div>
  )
}

export default PaymentSection