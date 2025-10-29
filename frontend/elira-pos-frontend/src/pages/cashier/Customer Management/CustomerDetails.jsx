import { Button } from '@/components/ui/button'
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card'
import { PlusIcon, StarIcon, UserIcon } from 'lucide-react'
import React from 'react'

const CustomerDetails = ({ customer }) => {
 /* if (!customer) {
    return (
      <div className="flex flex-col items-center justify-center h-full text-muted-foreground">
        <UserIcon className='h-4 w-4 mr-1' />
        <p className="text-lg">No Customer Selected</p>
      </div>
    )
  }
  */
  return (
    <div className="p-4">
      <div className="flex justify-between items-start mb-6">
        <div >
          <h2 className="">{customer.fullName}</h2>
          <p className="text-sm text-muted-foreground">{customer.email}</p>
          <p className="text-sm text-muted-foreground">{customer.phone}</p>
        </div>

        <Button>
          <PlusIcon className='h-4 w-4 mr-1' />
          Add Points
        </Button>
      </div>
      <div className="grid grid-cols-1 gap-4 mb-6 md:grid-cols-3">
        <Card>
          <CardHeader>
            <CardTitle>Loyalty Points</CardTitle>
          </CardHeader>

          <CardContent>
            <div className="flex items-center gap-2">
              <StarIcon className="h-4 w-4 mr-1 text-green-500" />
              <span>{customer.loyaltyPoints}</span>
            </div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader>
            <CardTitle>Total Orders</CardTitle>
          </CardHeader>

          <CardContent>
            <div className="flex items-center gap-2">
              <StarIcon className="h-4 w-4 mr-1 text-green-500" />
              <span>{customer.totalOrders}</span>
            </div>
          </CardContent>
        </Card>
        <Card>
          <CardHeader>
            <CardTitle>Total Spent</CardTitle>
          </CardHeader>

          <CardContent>
            <div className="flex items-center gap-2">
              <StarIcon className="h-4 w-4 mr-1 text-green-500" />
              <span>{customer.totalSpent}</span>
            </div>
          </CardContent>
        </Card>
      </div>

      <div className="">
        <Card>
          <CardHeader>
            <CardTitle>Purchase History</CardTitle>
            <p className="text-lg font-bold text-muted-foreground">
              {customer.averageOrderValue}$
            </p>
          </CardHeader>
        </Card>
      </div>
    </div>
  )
}

export default CustomerDetails