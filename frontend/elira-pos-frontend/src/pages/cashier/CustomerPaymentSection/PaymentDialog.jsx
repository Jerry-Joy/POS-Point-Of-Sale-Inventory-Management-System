import { Button } from '@/components/ui/button'
import { Dialog, DialogContent, DialogHeader, DialogTitle } from '@/components/ui/dialog'
import React from 'react'

const paymentMethods=[
  {id: 1, name: "Card", key: "CARD"},
  {id: 2, name: "Mobile Money", key: "MOMO"},
  {id: 3, name: "Cash", key: "CASH"}

]

const PaymentDialog = ({showPaymentDialog, setShowPaymentDialog}) => {

  const [paymentMethod, setPaymentMethod] = React.useState("CARD");
  return (
    <Dialog open={showPaymentDialog} onOpenChange={setShowPaymentDialog}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Payment</DialogTitle>
        </DialogHeader>

        <div className="space-y-4">
          <div className="text-center">
            <h1 className="text-lg font-bold text-yellow-600 dark:text-yellow-200">{899}$</h1>
            <p className="text-sm text-muted-foreground">
              Amount to be paid
            </p>
          </div>

          <div className="space-y-5">
            {
              paymentMethods.map((method) => (
                <Button onClick={() => setPaymentMethod(method.key)} variant={
                  paymentMethod==method.key? "default" : "outline"
                } key={method.id} className="w-full text-left">
                  {method.name}
                </Button>
              ))
            }
          </div>
        </div>
      </DialogContent>
    </Dialog>
  )
}

export default PaymentDialog