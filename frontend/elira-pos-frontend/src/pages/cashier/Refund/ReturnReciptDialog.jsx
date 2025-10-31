import { Button } from '@/components/ui/button'
import { Dialog, DialogContent, DialogFooter, DialogHeader, DialogTitle } from '@/components/ui/dialog'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import { PrinterIcon } from 'lucide-react'
import React from 'react'

const ReturnReciptDialog = ({
  showReturnReceiptDialog,
  setShowReturnReceiptDialog,
  selectedOrder
}) => {
  return (
    <Dialog open={showReturnReceiptDialog} onOpenChange={setShowReturnReceiptDialog}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Return Receipt</DialogTitle>
        </DialogHeader>
        <div className="bg-background max-h-96 overflow-y-auto p-4">
          <div className="">
            <h3 className="font-bold text-lg">Melcom ACCRA Branch</h3>
            <p className="">123 main Street, Dansoman</p>
            <p className="">Tel : 123-456-7890</p>
          </div>

          <div className="text-center mb-4">
            <h4 className="font-bold">Return Receipt</h4>
          </div>

          <div className="">
            {/* <p className=""> Return #: RTN - {Date.now().toString.substring(8)}</p> */}
            <p className="">Original Order : {selectedOrder.id}</p>
            <p className="">Date : {new Date().toLocaleString()}</p>
            <p className="">Customer : {selectedOrder?.customer?.fullName}</p>
          </div>

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

          <DialogFooter>
            <Button>
              <PrinterIcon className="h-4 w-4" />
              Print & Complete
            </Button>
          </DialogFooter>
        </div>
      </DialogContent>


    </Dialog>
  )
}

export default ReturnReciptDialog