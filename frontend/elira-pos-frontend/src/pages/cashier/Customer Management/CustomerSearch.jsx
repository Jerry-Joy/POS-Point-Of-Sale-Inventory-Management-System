import { Button } from '@/components/ui/button'
import { Input } from '@/components/ui/input'
import { PlusIcon } from 'lucide-react'
import React from 'react'

const CustomerSearch = () => {
  return (
    <div className="p-4 border-b">
      <div className="flex gap-2">
        <div className="relative flex-1">
          <Input placeholder='Search Customers...' type={"text"} className={"py-5"} />
        </div>
        <Button className={"py-5"}><PlusIcon className='h-4 w-4 mr-2' />
         Add New
        </Button>
      </div>
    </div>
  )
}

export default CustomerSearch