import { Badge } from '@/components/ui/badge'
import { Card, CardContent } from '@/components/ui/card'
import React from 'react'

const CustomerInformation = ({selectedOrder}) => {
  return (
    <Card>
      <CardContent className ={"p-4"} >
        <h3 className="font-semibold mb-2">Customer Information</h3>
        <div className="space-y-1 text-sm">

          <div className="flex justify-between">
            <span className="text-mmuted-foreground">Name :</span>
            <span className="">{selectedOrder.customer.fullName}</span>
          </div>

          <div className="flex justify-between">
            <span className="text-muted-foreground">Phone :</span>
            <span className="">{selectedOrder.customer.phone}</span>
          </div>

        </div>
      </CardContent>
    </Card>
  )
}

export default CustomerInformation