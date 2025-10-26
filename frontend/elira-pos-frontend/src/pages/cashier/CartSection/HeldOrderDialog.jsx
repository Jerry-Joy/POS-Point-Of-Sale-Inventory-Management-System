import { Button } from '@/components/ui/button'
import {  Card, CardContent } from '@/components/ui/card'
import { Dialog, DialogContent, DialogHeader } from '@/components/ui/dialog'
import { Play } from 'lucide-react'


import React from 'react'

const heldOrders = [
  {
    id: 'HO-001',
    items: [1, 1, 1, 1],
    timeStamp: '2024-10-01 14:30'
  },
  {
    id: 'HO-001',
    items: [1, 1, 1, 1],
    timeStamp: '2024-10-01 14:30'
  }
]

const HeldOrderDialog = ({showHeldOrdersDialog, setShowHeldOrdersDialog}) => {
  const handleResumeOrder = (order) => {
    console.log('Resuming order:', order);
  }
  return (
    <Dialog open={showHeldOrdersDialog} onOpenChange={setShowHeldOrdersDialog}>
      <DialogContent>
        <DialogHeader>Held Orders</DialogHeader>

        <div className='space-y-3'>
          {heldOrders.map((order) => (
            <Card key={order.id}>
              <CardContent>
                <div className="flex items-center justify-between">
                  <div>
                    <h3 className="font-medium">Order ID: #{order.id}</h3>
                  <p className="text-sm text-muted-foreground">
                    Items: {order.items.length}
                  </p>
                  <p className="text-xs text-muted-foreground">
                    Time: {new Date(order.timeStamp).toLocaleString()}
                  </p>
                  </div>
                  <Button size={"sm"} onClick={() => handleResumeOrder(order)}><Play className="w-4 h-4 mr-1" />
                  Resume Order
                </Button>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
      </DialogContent>
    </Dialog>
  )
}

export default HeldOrderDialog