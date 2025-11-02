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
  <div className="w-64 border-r border-border bg-sidebar p-6 flex 
  flex-col h-screen relative overflow-hidden">

      <div className="flex justify-center mb-8">
        <h1 className="flex items-center gap-3 text-xl font-bold text-sidebar-foreground">
          <PackageIcon className='w-6 h-6 text-primary' />
          BNCH MANAGER
        </h1>
      </div>

      {branch && (
        <div className="mb-8 px-4 py-4 bg-sidebar-accent/80 rounded-lg border border-border/50">
          <h3 className="font-medium text-sidebar-accent-foreground">
            {branch.name}
          </h3>
          <p className="text-xs text-secondary-foreground/70 mt-2">
            {branch.address}
          </p>
        </div>
      )}

  <nav className='space-y-2.5 flex-1 mb-6 overflow-y-auto pr-2'>
        {navItems.map((item) => (
          <Link
            className={`flex items-center px-4 py-3 rounded-md hover:bg-sidebar-accent/80 transition-colors duration-200 
              ${location.pathname === item.path 
                ? 'bg-sidebar-accent text-sidebar-accent-foreground font-medium' 
                : 'text-sidebar-foreground hover:text-sidebar-accent-foreground'
              }`}
            key={item.path}
            to={item.path}
          >
            <div className="flex items-center gap-4">
              {item.icon}
              <span>{item.name}</span>
            </div>
          </Link>
        ))}
      </nav>

      <div className="pt-4 border-t border-border/50">
        <Button 
          variant="ghost" 
          className="w-full py-3 px-4 justify-start gap-4 text-destructive hover:text-destructive hover:bg-destructive/10"
        >
          <LogOut className="w-5 h-5" />
          <span>Logout</span>
        </Button>
      </div>
    </div>
  )
}

export default BranchSidebar