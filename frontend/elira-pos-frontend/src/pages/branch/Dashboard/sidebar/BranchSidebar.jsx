import { Button } from '@/components/ui/button'
import { CreditCard, Cross, FileText, LayoutDashboard, LogOut, Package, Package2, PackageIcon, Settings, ShoppingBag, UserCircle, Users, X } from 'lucide-react'
import React from 'react'
import { Link, useLocation } from 'react-router-dom'

const navItems = [
  {
    name: 'Dashboard',
    path: "/branch/dashboard",
    icon: <LayoutDashboard className='w-5 h-5' />
  },
  {
    name: 'Orders',
    path: "/branch/orders",
    icon: <ShoppingBag className='w-5 h-5' />
  },
  {
    name: 'Transactions',
    path: "/branch/transactions",
    icon: <CreditCard className='w-5 h-5' />
  },
  {
    name: 'Inventory',
    path: "/branch/inventory",
    icon: <Package className='w-5 h-5' />
  },
  {
    name: 'Employees',
    path: "/branch/employees",
    icon: <Users className='w-5 h-5' />
  },
  {
    name: 'Customers',
    path: "/branch/customers",
    icon: <UserCircle className='w-5 h-5' />
  },
  {
    name: 'Reports',
    path: "/branch/reports",
    icon: <FileText className='w-5 h-5' />
  },
  {
    name: 'Settings',
    path: "/branch/settings",
    icon: <Settings className='w-5 h-5' />
  },
];

const branch = {
  name: "Accra Dansoman branch",
  address: "street 123, near Ebenezer SHS"
}

const BranchSidebar = () => {
  const location = useLocation();
  return (
    <div className="w-64 border-r border-border bg-sidebar p-4 flex 
    flex-col h-full relative">

      <div className="flex justify-center">
        <h1 className="flex item-center gap-3 text-xl font-bold text-sidebar-foreground">
          <PackageIcon className='w-5 h-5 text-primary' />
          BNCH MANAGER
        </h1>
      </div>

      {branch && (<div className="mb-6 px-4 py-3 bg-sidebar-accent rounded-lg">
        <h3 className="font-medium text-sidebar-accent-foreground">
          {branch.name}
        </h3>
        <p className="text-xs text-secondary-foreground/70 mt-1">
          {branch.address}
        </p>
      </div>)}

      <nav className='space-y-2 flex-1'>
        {navItems.map((item) => (
          <Link

            className={`flex items-center justify-between p-3 rounded-md hover:bg-sidebar-accent transition-colors ${location.pathname === item.path ? 'bg-sidebar-accent text-sidebar-accent-foreground' : 'text-sidebar-foreground'}`}
            key={item.path}
            to={item.path}
          >
            <div className="flex items-center gap-3">
              {item.icon}
              <span className="">{item.name}</span>
            </div>
          </Link>
        ))}
      </nav>

      <div className="">
        <Button className={"w-full py-6"}>
          <LogOut /> Logout
        </Button>
      </div>
    </div>
  )
}

export default BranchSidebar