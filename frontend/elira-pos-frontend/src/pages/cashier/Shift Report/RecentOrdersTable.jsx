import { Button } from '@/components/ui/button'
import { Card, CardContent } from '@/components/ui/card'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import React from 'react'

const shiftData = {
  recentOrders:[
    {
      id: 1,
      createdAt: "10:15 AM",
      paymentType: "CASH",
      totalAmount: 150.00,
    },
    {
      id: 2,
      createdAt: "11:30 AM",
      paymentType: "CARD",
      totalAmount: 200.00,
    },
  ]
}

const RecentOrdersTable = () => {
  return (
    <Card>
      <CardContent>
        <h2 className="text-xl font-semibold mb-4">Recent Orders</h2>
        <Table>
            <TableHeader>
              <TableRow>
                <TableHead className="w-[150px]">Order ID</TableHead>
                <TableHead className="w-[150px]">Time</TableHead>
                <TableHead className="w-[150px]">Payment</TableHead>
                <TableHead className="text-right">Amount</TableHead>
              </TableRow>
            </TableHeader>

            <TableBody>
              {shiftData.recentOrders.map((order) => (
                <TableRow key={order.id}>
                  <TableCell>{order.id}</TableCell>
                  <TableCell>{order.createdAt}</TableCell>
                  <TableCell>{order.paymentType}</TableCell>
                  <TableCell className="text-right">{order.totalAmount}</TableCell>
                  
                </TableRow>
              ))}
            </TableBody>
          </Table>
      </CardContent>
    </Card>
  )
}

export default RecentOrdersTable