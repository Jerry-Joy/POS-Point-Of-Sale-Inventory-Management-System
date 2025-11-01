import { Button } from '@/components/ui/button'
import { Bell, User } from 'lucide-react'
import React from 'react'

const branch = {
  name: "Accra Dansoman branch",
  address: "street 123, near Ebenezer SHS"
}

const userProfile = {
  name: "Selly Morgaan",
  email: "selly@gmail.com"
}

const BranchTopbar = () => {
  return (
    <header className="bg-background border-b px-6 py-4 flex 
    items-center justify-between">
      <div className="">
        <h1 className="">
          {branch ? branch.name : "Branch Dashboard"}
        </h1>
        <p className="">
          {new Date().toLocaleDateString("en-US", {
            weekday: "long",
            year: "numeric",
            month: "long",
            day: "numeric",
          })}
        </p>
      </div>

      <div className="flex items-center gap-4">

        <Button>
          <Bell className='h-5 w-5' />
        </Button>

        <div className="flex item-center gap-3">
          <div className="h-9 w-9 rounded-full bg-primary/10 flex
          items-center justify-center">
            <User />
          </div>

          <div className="hidden md:block">
            <p className="text-sm font-medium text-foreground">
              {userProfile.name}
            </p>
            <p className="text-xs text-muted-foreground">
              {userProfile.email}
            </p>

          </div>
        </div>
      </div>
    </header>
  )
}

export default BranchTopbar