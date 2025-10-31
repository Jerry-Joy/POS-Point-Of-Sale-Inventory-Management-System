import { Badge } from '@/components/ui/badge'
import { Button } from '@/components/ui/button'
import { Card, CardContent } from '@/components/ui/card'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import { ChevronLeftIcon } from 'lucide-react'
import React from 'react'

const OrderDetailsSection = ({ handleSelectOrder, selectedOrder }) => {
  return (
    <div className="w-1/2 border-r p-4">
      <div className="mb-4">
        <Button onClick={() => handleSelectOrder(null)}><ChevronLeftIcon />
          back to order table
        </Button>
      </div>

      <Card>
        <CardContent>
          <div className="flex justify-between items-start mb-4">
            <div className="">
              <h2 className="font-semibold text-lg">Order {selectedOrder.id}</h2>
              <p className="">{selectedOrder.createdAt}</p>
            </div>

            <Badge variant={"outline"}>
              {selectedOrder.paymentType}
            </Badge>
          </div>

          <div className="mb-4">
            <h3 className="font-medium text-sm text-muted-foreground mb-2">
              {selectedOrder?.customer?.fullName}
            </h3>
            <h3 className="text-sm">{selectedOrder?.customer?.phone}</h3>
          </div>

          <div className="">
            <h2 className="font-medium text-sm text-muted-foreground mb-2">
              Order summary
            </h2>

            <div className="text-sm">
              <div className="flex justify-between">
                <span className="">Total Items : {selectedOrder.items.length}</span>
              </div>

              <div className="">
                <span className="">Order Total : ${selectedOrder.totalAmount}</span>
              </div>
            </div>
          </div>
        </CardContent>
      </Card>

      <div className="flex-1 overflow-auto mt-10">
        <h2 className="text-xl font-semibold mb-4">Order Items</h2>
        <Table>
          <TableHeader>
            <TableRow>
              <TableHead className="w-[150px]">Image</TableHead>
              <TableHead className="w-[150px]">Item</TableHead>
              <TableHead className="w-[150px]">Quantity</TableHead>
              <TableHead className="text-right">Price</TableHead>
              <TableHead className="text-right">Total</TableHead>
            </TableRow>
          </TableHeader>

          <TableBody>
            {selectedOrder.items.map((item) => (
              <TableRow key={item.id}>
                <TableCell>
                  <div className="w-10 h-10">
                    {item.product?.image && <img
                      src={item.product?.image}
                      className="w-10 h-10 object-cover rounded-md" />}
                  </div>
                </TableCell>
                <TableCell>
                  <div className='flex flex-col'>
                    <span className="font-medium">{item.product.name.slice(0, 20)}...</span>
                    <span className="text-xs text-gray-500">
                      SKU: {item.product?.sku}
                    </span>
                  </div>
                </TableCell>
                <TableCell>{item.quantity}</TableCell>
                <TableCell>${item.product?.sellingPrice}</TableCell>
                <TableCell className="text-right">
                  ${(item.product?.sellingPrice * item.quantity)?.toFixed(1)}
                </TableCell>

              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div>
    </div>
  )
}

export default OrderDetailsSection