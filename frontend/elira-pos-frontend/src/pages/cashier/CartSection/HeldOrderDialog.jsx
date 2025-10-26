import { Dialog, DialogHeader } from '@/components/ui/dialog'
import { DialogContent } from '@radix-ui/react-dialog'
import { timeStamp } from 'console'
import React from 'react'

const heldOrders = [
  {
    id: 'HO-001',
    items: [1,1,1,1],
    timeStamp: '2024-10-01 14:30'
  },
  {
    id: 'HO-001',
    items: [1,1,1,1],
    timeStamp: '2024-10-01 14:30'
  }
]

const HeldOrderDialog = () => {
  return (
    <Dialog>
      <DialogContent>
        <DialogHeader>Held Orders</DialogHeader>

        <div className='space-y-3'>

        </div>
      </DialogContent>
    </Dialog>
  )
}

export default HeldOrderDialog