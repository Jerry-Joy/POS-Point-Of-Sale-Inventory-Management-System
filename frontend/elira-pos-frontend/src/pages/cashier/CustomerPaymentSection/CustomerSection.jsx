import { Button } from '@/components/ui/button';
import { Card, CardContent } from '@/components/ui/card';
import { Edit, User } from 'lucide-react'
import React from 'react'

const CustomerSection = () => {

  const selectedCustomer = {
    fullName: "John Doe",
    phone: "123-456-7890"
  };
  return (
    <div className='p-4 border-b'>
      <h2 className="text-lg font-semibold mb-3 flex items-center"><User className='w-5 h-5 mr-2' />
       Customer 
      </h2>

      {
        selectedCustomer ? (
        <Card className={"border-yellow-400 bg-yellow-50 dark:bg-yellow-900 dark:border-yellow-700"}>

          <CardContent className={"p-3 flex items-center justify-between gap-5"}>
            <div className="">
              <h3 className="font medium text-yellow-700 dark:text-yellow-200">
              {selectedCustomer.fullName}
            </h3>

            <p className='text-sm text-yellow-600 dark:text-yello-300'>
              {selectedCustomer.phone}
            </p>
            </div>

           <div className="">
             <Button variant={"outline"} 
            size={"small"} 
            className={"mt-2 w-full"}>
              <Edit />
            </Button>
           </div>
          </CardContent>

        </Card>
      ) : (<div>
          <p className='text-sm text-muted-foreground'>
            No customer selected. Please select a customer too proceed.
          </p>
          <Button>
            Select Customer
          </Button>
        </div>
      )}
    </div>
  )
}

export default CustomerSection