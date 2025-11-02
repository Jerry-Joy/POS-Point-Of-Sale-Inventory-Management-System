import React from 'react'
import BranchSidebar from '../sidebar/BranchSidebar'
import BranchTopbar from '../topbar/BranchTopbar'
import { Outlet } from 'react-router'

const BranchLayout = ({children}) => {
  return (
    <div className="flex h-screen bg-gradient-to-br from-primary/5 via-background to-primary/10">

      <BranchSidebar />

      <div className="flex-1 flex flex-col">
        <BranchTopbar />
        <main className='flex-1 overflow-y-auto p-8 md:p-10 lg:p-12 m-4'>
          {children || <Outlet />}
        </main>
      </div>
    </div>
  )
}

export default BranchLayout