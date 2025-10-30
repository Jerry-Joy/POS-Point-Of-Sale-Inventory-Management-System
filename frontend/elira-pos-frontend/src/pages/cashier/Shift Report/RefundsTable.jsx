import { Card, CardContent } from '@/components/ui/card'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import React from 'react'

const shiftData = {
  refunds:[
    {
      id: 1,
      orderId: 101,
      reason: "Damaged Item",
      amount: 50.00,
    }
  ]
}

const RefundsTable = () => {
  return (
     <Card>
          <CardContent>
            <h2 className="text-xl font-semibold mb-4">Recent Orders</h2>
            <Table>
                <TableHeader>
                  <TableRow>
                    <TableHead className="w-[150px]">Refund ID</TableHead>
                    <TableHead className="w-[150px]">Order ID</TableHead>
                    <TableHead className="w-[150px]">Reason</TableHead>
                    <TableHead className="text-right">Amount</TableHead>
                  </TableRow>
                </TableHeader>
    
                <TableBody>
                  {shiftData.refunds.map((refund) => (
                    <TableRow key={refund.id}>
                      <TableCell>{refund.id}</TableCell>
                      <TableCell>{refund.orderId}</TableCell>
                      <TableCell>{refund.reason}</TableCell>
                      
                      <TableCell className="text-right">${refund.amount}</TableCell>
                      
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
          </CardContent>
        </Card>
  )
}

export default RefundsTable