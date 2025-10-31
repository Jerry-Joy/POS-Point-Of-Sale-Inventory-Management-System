import { Button } from '@/components/ui/button'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import { EyeIcon, Printer } from 'lucide-react'
import React from 'react'

const orders = [
  {
    id: 1,
    createdAt: "Oct 3, 2025, 10:15 AM",
    customer: {
      fullName: "John Doe",
      phone: "123-456-7890",
    },
    totalAmount: 150.00,
    paymentType: "CASH",
    status: "COMPLETED",
    items: [
      {
        id: 1,
        product: {
          image: "https://tse2.mm.bing.net/th/id/OIP.CRUL6-HM53MSE1v05g_FAwHaJo?rs=1&pid=ImgDetMain&o=7&rm=3",
          name: "Men black T-Shirt",
          sellingPrice: 25.00,
          sku: "TSHIRT-BLK-001"
        },
        quantity: 2
      }
    ]
  }
]

const OrderTable = ({handleSelectOrder}) => {
  return (
    <div>

      <Table>
        <TableHeader>
          <TableRow>
            <TableHead className="">Order ID</TableHead>
            <TableHead className="">Date/Time</TableHead>
            <TableHead className="">Customer</TableHead>
            <TableHead className="">Amount</TableHead>
            <TableHead className="">Payment Type</TableHead>
            <TableHead className="">Status</TableHead>
            <TableHead className="text-right">Action</TableHead>
          </TableRow>
        </TableHeader>

        <TableBody>
          {orders.map((order) => (
            <TableRow key={order.id}>
              <TableCell>{order.id}</TableCell>
              <TableCell>{order.createdAt}</TableCell>
              <TableCell>{order.customer?.fullName}</TableCell>
              <TableCell>{order.totalAmount}</TableCell>
              <TableCell>{order.paymentType}</TableCell>
              <TableCell>{order.status}</TableCell>
              <TableCell className="text-right">

                <Button onClick={
                   () => handleSelectOrder(order)
                  
                }
                  >
                  select for return
                </Button>

              </TableCell>

            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  )
}

export default OrderTable