
import { Button } from '@/components/ui/button'
import { CreditCard, Pause } from 'lucide-react'
import React from 'react'
import PaymentDialog from './PaymentDialog';

const cartItems = [1];

const PaymentSection = () => {
  const[showPaymentDialog, setShowPaymentDialog] = React.useState(false)
  
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
          <Button 
          onClick={() => setShowPaymentDialog(true)}
          disabled={cartItems.length === 0} className={"w-full py-3 text-lg font-semibold"}>
            <CreditCard className='w-5 h-5 mr-2' />
            Proccess Payment
          </Button>

          <Button variant={"outline"} disabled={cartItems.length === 0} className={"w-full py-3 text-lg font-semibold"}>
            <Pause className='w-5 h-5 mr-2' />
            Hold Order
          </Button>
        </div>
      </div>

      <PaymentDialog 
        showPaymentDialog={showPaymentDialog}
        setShowPaymentDialog={setShowPaymentDialog}
      />
      
    </div>
  )
}

export default PaymentSection