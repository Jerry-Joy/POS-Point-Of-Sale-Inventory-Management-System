import { Card, CardContent } from '@/components/ui/card'
import { CreditCard } from 'lucide-react'

import React from 'react'

const shiftData = {
  paymentSummaries:[
    {
      type: "CASH",
      totalAmount: 600.00,
      transactionCount: 20
    },
    {
      type: "CREDIT CARD",
      totalAmount: 500.00,
      transactionCount: 15
    },
    {
      type: "MOBILE PAYMENT",
      totalAmount: 150.00,
      transactionCount: 10
    }
  ],
  totalSales: 1250.00
}

const PaymentSummaryCard = () => {
  return (
    <Card>
      <CardContent>
        <h2 className="text-xl font-semibold mb-4">Payment Summary</h2>

        <div className="space-y-4">
          {
            shiftData.paymentSummaries.map((payment) =>
            <div className='flex items-center' key={payment.type}>
              <div className="w-10 h-10 flex items-center justify-center rounded-full bg-primary/10 mr-4">
                <CreditCard />
              </div>

              <div className="flex-1">
                <div className="flex justify-between">
                  <span className='font-medium'>{payment.type}</span>
                  <span className='font-bold'>${payment.totalAmount}</span>
                </div>

                <div className="flex justify-between text-sm text-muted-forground">
                  <span>{payment.transactionCount} transactions</span>
                  <span>{((payment.totalAmount/shiftData.totalSales)*100).toFixed(1)}% 

                  </span>
                </div>
              </div>
            </div>)
          }
        </div>
      </CardContent>
    </Card>
  )
}

export default PaymentSummaryCard