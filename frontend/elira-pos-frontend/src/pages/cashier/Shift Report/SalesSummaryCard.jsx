import { Card, CardContent } from '@/components/ui/card'
import React from 'react'

const shiftData = {
  cashier:{
    fullName: 'John Dobinson'
  },
  shiftStart: 'Oct 1, 2025 09:00 AM',
  shiftEnd: "",
  totalOrders: 45,
  totalSales: "$1,250.00",
  totalRefund: "$50.00",
  netSales: "$1,200.00"
}
const SalesSummaryCard = () => {
  return (
    <Card>
      <CardContent>
        <h2 className="text-xl font-semibold mb-4">Sales Summary</h2>

        <div className="space-y-2">
          <div className="flex justify-between">
            <span className='text-muted-foreground'>Total Orders: </span>
            <span className='font-medium'>{shiftData.totalOrders}</span>
          </div>

          <div className="flex justify-between">
            <span className='text-muted-foreground'>Total Sales: </span>
            <span className='font-medium'>{shiftData.totalSales}</span>
          </div>

          <div className="flex justify-between">
            <span className='text-muted-foreground'>Total Refund: </span>
            <span className='font-medium text-red-500'>{shiftData.totalRefund}</span>
          </div>

          <div className="flex justify-between border-t">
            <span className='text-muted-foreground'>Net Sales: </span>
            <span className='font-medium'>{shiftData.netSales}</span>
          </div>
        </div>
      </CardContent>
    </Card>
  )
}

export default SalesSummaryCard